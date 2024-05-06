resource "google_compute_firewall" "allow-ssh" {
  name    = "allow-ssh"
  project = var.project_id
  network = google_compute_network.gke-network-main.self_link
  allow {
    protocol = "tcp"
    ports    = ["22"]
  }
  source_ranges = ["0.0.0.0/0"]
  
}