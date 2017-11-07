package org.jeecgframework.core.timer;

import java.lang.reflect.Method;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 
 * @Title: DataBaseMethodInvokingJobDetailFactoryBean
 * @Description:
 * @Author: zhaotf
 * @Since:2017年11月6日 下午4:38:39
 * @Version:1.0
 */
public class DataBaseMethodInvokingJobDetailFactoryBean extends MethodInvokingJobDetailFactoryBean {

	public void me() {
		DataBaseMethodInvokingJobDetailFactoryBean bean = new DataBaseMethodInvokingJobDetailFactoryBean();
		MethodInvokingJob job = new DataBaseMethodInvokingJobDetailFactoryBean.MethodInvokingJob();
		// StatefulMethodInvokingJob;
		new MethodInvokingJob();
		// job.setMethodInvoker(methodInvoker);
	}
	
	@Override
	public void afterPropertiesSet() throws ClassNotFoundException, NoSuchMethodException {
		super.afterPropertiesSet();
		
	}

	public static class MyDetailQuartzJobBean extends QuartzJobBean {
		private String targetObject;
		private String targetMethod;
		private ApplicationContext ctx;

		@Override
		protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
			try {
				Object otargetObject = ctx.getBean(targetObject);
				Method m = null;
				try {
					m = otargetObject.getClass().getMethod(targetMethod, new Class[] {});
					m.invoke(otargetObject, new Object[] {});
				} catch (SecurityException e) {
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				throw new JobExecutionException(e);
			}
		}

		public void setApplicationContext(ApplicationContext applicationContext) {
			this.ctx = applicationContext;
		}

		public void setTargetObject(String targetObject) {
			this.targetObject = targetObject;
		}

		public void setTargetMethod(String targetMethod) {
			this.targetMethod = targetMethod;
		}
	}

}
