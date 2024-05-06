resource "google_compute_subnetwork" "private_subnet" {

  name                     = var.subnetwork
  project                  = var.project_id
  region                   = var.region
  network                  = google_compute_network.gke-network-main.self_link
  ip_cidr_range            = "10.0.0.0/18"
  private_ip_google_access = true

  secondary_ip_range {
    range_name = var.ip_range_pods_name
    ip_cidr_range =  "10.48.0.0/14"
  }
  secondary_ip_range {
    range_name = var.ip_range_services_name
    ip_cidr_range         = "10.52.0.0/20"
  }
}
