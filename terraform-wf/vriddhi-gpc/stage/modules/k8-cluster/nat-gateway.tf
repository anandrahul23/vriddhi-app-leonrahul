resource "google_compute_router_nat" "google-nat-gateway" {
    name            = var.nat_gateway_name
    project         = var.project_id
    region          = var.region
    router          = google_compute_router.router.name
    nat_ip_allocate_option = "MANUAL_ONLY"
    source_subnetwork_ip_ranges_to_nat = "LIST_OF_SUBNETWORKS"
    depends_on      = [google_compute_router.router]
    subnetwork {
        name = google_compute_subnetwork.private_subnet.name
        source_ip_ranges_to_nat = ["ALL_IP_RANGES"]
    }
    nat_ips = [ google_compute_address.nat_ip.self_link ]
  
}

resource "google_compute_address" "nat_ip" {    
    name = "nat-ip"
    project = var.project_id
    region = var.region
    address_type = "EXTERNAL"
    network_tier = "PREMIUM"
    depends_on = [google_project_service.compute]
  
}