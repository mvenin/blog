package org.cloudfoundry.env;

import javax.validation.constraints.NotNull;

public class HrFile {

	@NotNull
	private Integer fileId;

	@NotNull
	private String jobName;

	@NotNull(message = "{sysper.notBlank}")
	private Integer jobId;

	public Integer getFileId() {
		return fileId;
	}

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}
	
	
}
