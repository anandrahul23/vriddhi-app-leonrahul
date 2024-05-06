

resource "google_project_iam_member" "compute_engine_admin" {
  project = var.project_name
  role    = "roles/compute.admin"
  member  = "serviceAccount:${var.service_account_email}"
}
resource "google_compute_instance" "test-compute-engine" {
  name         = var.test_compute_engine_name
  machine_type = var.test_machine_type

  boot_disk {
    initialize_params {
      image = "debian-10-buster-v20240417"
    }
  }

  network_interface {
    network = "default"

    access_config {
      // Ephemeral IP
    } 
  }

  service_account {
    email = var.service_account_email
    scopes = ["userinfo-email", "compute-ro", "storage-ro"]
  }
}
