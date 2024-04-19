

terraform {
  required_providers {
    google = {
      source = "hashicorp/google"
      version = "5.24.0"
    }
  }
}

provider "google" {
  # Configuration options
  project = "vriddhi-419806"
  region = "us-west4"       # London region
  zone        = "europe-west4-b"   # Nearest zone to London
  credentials = "gcp_key.json"
}