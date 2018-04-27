package org.jeecgframework.core.timer;

import java.text.ParseException;

import org.jeecgframework.web.system.pojo.base.TSTimeTaskEntity;
import org.jeecgframework.web.system.service.TimeTaskServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

/**
 * 
 * @Title: DataBaseCronTriggerBeanLocal
 * @Description:在原有功能的基础上面增加数据库的读取
 * @Author: zhaotf
 * @Since:2017年11月6日 下午4:25:25
 * @Version:1.0
 */
public class DataBaseCronTriggerBeanLocal extends CronTriggerFactoryBean {
	@Autowired
	private TimeTaskServiceI timeTaskService;

	/**
	 * 读取数据库更新文件
	 * 
	 * @throws ParseException
	 */
	@Override
	public void afterPropertiesSet() throws ParseException {
		super.afterPropertiesSet();
		TSTimeTaskEntity task = timeTaskService.findUniqueByProperty(TSTimeTaskEntity.class, "taskId",
				this.getObject().getName());
		if (task != null && task.getIsEffect().equals("1")
				&& !task.getCronExpression().equals(this.getObject().getCronExpression())) {
			this.setCronExpression(task.getCronExpression());
			DynamicTask.updateSpringMvcTaskXML(this.getObject(), task.getCronExpression());
		}
	}

}
