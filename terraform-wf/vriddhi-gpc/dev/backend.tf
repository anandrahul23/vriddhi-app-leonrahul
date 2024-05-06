terraform {
    backend "gcs" {
      bucket  = "terraform-state-vriddhi-gpc-dev"
      prefix  = "terraform/state"
    }
  }
  