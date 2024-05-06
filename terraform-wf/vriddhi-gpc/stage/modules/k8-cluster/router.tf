resource "google_compute_router" "router" {
    name    = var.router_name
    project = var.project_id
    region  = var.region
    
    network = google_compute_network.gke-network-main.self_link
  
}