resource "google_service_account" "kubernetes" {
  account_id   = "kubernetes-admin"
  display_name = "Kubernetes Admin"
  project      = var.project_id
  
}

resource "google_container_node_pool" "general" {   
    name       = "general"
    project    = var.project_id
    location   = var.zone
    cluster    = google_container_cluster.primary.id
    node_count = var.node_count
    autoscaling {
        min_node_count = 0
        max_node_count = 2
    }
    node_config {
        preemptible = false
        machine_type = var.machine_type
        disk_size_gb = var.disk_size_gb
        #disk_type    = var.disk_type
        labels = {
          env = var.env_name
          role = "general"
        }
        service_account = google_service_account.kubernetes.email
       
       
        oauth_scopes = [
       "https://www.googleapis.com/auth/cloud-platform"
        ]
    }
    management {
        auto_repair  = true
        auto_upgrade = true
    }
    depends_on = [google_service_account.kubernetes]
  
}

resource "google_container_node_pool" "spot" {
    name       = "spot"
    project    = var.project_id
    location   = var.zone
    cluster    = google_container_cluster.primary.id
    node_count = var.node_count
    autoscaling {
        min_node_count = 0
        max_node_count = 2
    }
    node_config {
        preemptible = true
        machine_type = var.machine_type
        disk_size_gb = var.disk_size_gb
        #disk_type    = var.disk_type
        labels = {
          env = var.env_name
          role = "spot"
        }
        taint {
            key    = "instance_type"
            value  = "spot"
            effect = "NO_SCHEDULE"
        }
        service_account = google_service_account.kubernetes.email
        oauth_scopes = [
       "https://www.googleapis.com/auth/cloud-platform"
        ]
    }
    management {
        auto_repair  = true
        auto_upgrade = true
    }
    depends_on = [google_service_account.kubernetes]
  
}