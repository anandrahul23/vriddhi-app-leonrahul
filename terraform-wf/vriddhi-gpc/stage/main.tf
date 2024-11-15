
/*module "gcp_compute_engine" {
  source                   = "./modules/gcp_compute_engine"
  test_compute_engine_name = "my-compute-engine1-staging"
  project_name             = "vriddhi-419806"
  service_account_email    = "vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"
  test_machine_type        = "n1-standard-1"
}*/

module "gcp_bucket" {
  source = "./modules/gcp_bucket"
  bucket_tf_state = "terraform-state-vriddhi-gpc-staging"
  
}

module "k8-cluster" {
  source = "./modules/k8-cluster"
  project_id = "vriddhi-419806"
  cluster_name = "vriddhi-gke-staging"
  region = "us-east1"
  network = "gke-network-staging"
  node_count = 2
  disk_size_gb = 50
  machine_type = "n1-standard-2"
}

