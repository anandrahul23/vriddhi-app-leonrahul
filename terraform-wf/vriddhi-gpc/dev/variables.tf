

variable "project_name" {

  description = "the name of the root gcp project"
  type        = string
  default     = "vriddhi-419806"
}



variable "gcp_region" {

  description = "gcp region"
  type        = string
  default     = "us-east1"

}

variable "gcp_zone" {
  description = "gcp region"
  type        = string
  default     = "us-east1-b"

}

variable "gcp_key" {
  description = "gcp key for service account"
  type        = string
  default     = "gcp-key.json"

}
