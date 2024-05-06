

terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = ">= 5.24.0"
    }
  }
}

provider "google" {
  # Configuration options
  project = var.project_name
  region = var.gcp_region       
  zone        = var.gcp_zone  
  credentials = file("${path.root}/gcp-key.json")
}