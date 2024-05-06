
module "gcp_compute_engine" {
  source                   = "./modules/gcp_compute_engine"
  test_compute_engine_name = "my-compute-engine1"
  project_name             = "vriddhi-419806"
  service_account_email    = "vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"
  test_machine_type        = "n1-standard-1"
}

module "gcp_bucket" {
  source = "./modules/gcp_bucket"
  bucket_tf_state = "terraform-state-vriddhi-gpc"
  
}

