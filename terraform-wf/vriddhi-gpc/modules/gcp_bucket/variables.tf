
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
