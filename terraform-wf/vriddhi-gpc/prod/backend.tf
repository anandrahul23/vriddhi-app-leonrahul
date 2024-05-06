terraform {
    backend "gcs" {
      bucket  = "terraform-state-vriddhi-gpc-prod"
      prefix  = "terraform/state"
    }
  }
  