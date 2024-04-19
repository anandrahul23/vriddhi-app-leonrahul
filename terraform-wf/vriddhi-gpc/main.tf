

resource "google_project_iam_member" "project" {
  project = "vriddhi-419806"
  role    = "roles/compute.admin"
  member  = "serviceAccount:vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"
}
resource "google_compute_instance" "default" {
  name         = "terraform-instance"
  machine_type = "f1-micro"

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
    email = "vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"
    scopes = ["userinfo-email", "compute-ro", "storage-ro"]
  }
}
