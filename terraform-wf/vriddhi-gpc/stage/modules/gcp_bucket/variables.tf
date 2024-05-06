
variable "project_name" {

  description = "the name of the root gcp project"
  type        = string
  default     = "vriddhi-419806"
}

variable "service_account_email" {

  description = "Service account used to provision resource"
  type        = string
  default     = "vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"

}

variable "storage_service_account_email" {

  description = "Service account used to provision resource"
  type        = string
  default     = "service-288566726775@gs-project-accounts.iam.gserviceaccount.com"
  
}

variable "bucket_tf_state" {

  description = "bucket to store terraform state file"
  type        = string

}
