resource "google_container_cluster" "primary" {
  name     = var.cluster_name
  location = var.zone
  project  = var.project_id

  remove_default_node_pool = true

  initial_node_count = var.node_count
  network = google_compute_network.gke-network-main.self_link
  subnetwork = google_compute_subnetwork.private_subnet.self_link
  logging_service = "logging.googleapis.com/kubernetes"
  networking_mode = "VPC_NATIVE"
  addons_config {
    horizontal_pod_autoscaling {
      disabled =  false
    }
    http_load_balancing {
        disabled =  true
        
    }

  }
release_channel {
    channel = "REGULAR"
  }
  workload_identity_config {
    workload_pool = "vriddhi-419806.svc.id.goog"
  }

  ip_allocation_policy {
    
    cluster_secondary_range_name = var.ip_range_pods_name
    services_secondary_range_name = var.ip_range_services_name
  }

  private_cluster_config {
    enable_private_endpoint = false
    enable_private_nodes    = true
    master_ipv4_cidr_block = "172.16.0.0/28"
  }


  /*jenkins service account
  master_authorized_networks_config {
    cidr_blocks {
      cidr_block   = "
  }*/
  /*master_auth {
    username = ""
    password = ""

    client_certificate_config {
      issue_client_certificate = false
    }
  }

  node_config {
    oauth_scopes = [
      "https://www.googleapis.com/auth/logging.write",
      "https://www.googleapis.com/auth/monitoring",
    ]

    labels = {
      "env" = var.env_name
    }

    tags = ["gke-node"]
  }

  timeouts {
    create = "30m"
    update = "30m"
    delete = "30m"
  }*/
  
}