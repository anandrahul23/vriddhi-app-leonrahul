resource "google_project_service" "compute" {

  project = var.project_id
  service = "compute.googleapis.com"
}

resource "google_project_service" "container" {

  project = var.project_id
  service = "container.googleapis.com"
}

resource "google_compute_network" "gke-network-main" {
  name                            = var.network
  project                         = var.project_id
  routing_mode                    = "REGIONAL"
  auto_create_subnetworks         = false
  mtu                             = 1460
  delete_default_routes_on_create = false
  depends_on                      = [google_project_service.compute, google_project_service.container]
}
