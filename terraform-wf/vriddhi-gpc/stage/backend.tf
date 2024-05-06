terraform {
    backend "gcs" {
      bucket  = "terraform-state-vriddhi-gpc-staging"
      prefix  = "terraform/state"
    }
  }
  