
/*resource "google_kms_key_ring_iam_member" "bucket_kms_key_ring_iam_member" {
    key_ring_id = google_kms_key_ring.keyring.id
    role        = "roles/cloudkms.admin"
    member      = "serviceAccount:${var.storage_service_account_email}"
  
}

resource "google_kms_key_ring" "keyring" {
  name     = "keyring-gcp_bucket"
  location = "us"
}

resource "google_storage_bucket_iam_member" "bucket_iam_member" {
  bucket = google_storage_bucket.terraform_state_bucket.name
  role   = "roles/cloudkms.admin"
  member = "serviceAccount:${var.service_account_email}"
  
}

resource "google_kms_crypto_key" "terraform_state_bucket" {
  name            = "crypto-key-gcp_bucket"
  key_ring        = google_kms_key_ring.keyring.id
  rotation_period = "7776000s"

#   lifecycle {
#     prevent_destroy = true
#   }
}

resource "google_project_iam_member" "kms_admin" {
  project = var.project_name
  role    = "roles/cloudkms.admin"
  member  = "serviceAccount:${var.service_account_email}"
}

// Assign IAM role(s) to a member for the Crypto Key
resource "google_kms_crypto_key_iam_member" "crypto_key_iam_member" {
  crypto_key_id = google_kms_crypto_key.terraform_state_bucket.id
  role          = "roles/cloudkms.admin"
  member        = "serviceAccount:${var.service_account_email}"
}
*/

resource "google_project_iam_member" "cloud_storage_admin" {
  project = var.project_name
  role    = "roles/storage.admin"
  member  = "serviceAccount:${var.service_account_email}"
#   lifecycle {
#     prevent_destroy = true
#   }
}


resource "google_storage_bucket_iam_member" "terraform_state_bucket_iam_member" {
  bucket = google_storage_bucket.terraform_state_bucket.name
  role   = "roles/storage.admin"
  member = "serviceAccount:${var.service_account_email}"
    # lifecycle {
    #     prevent_destroy = true
    # }

}


resource "google_storage_bucket" "terraform_state_bucket" {
  name          = var.bucket_tf_state
  force_destroy = false
  location      = "US"
  storage_class = "STANDARD"
  versioning {
    enabled = true
  }
#   lifecycle {
#     prevent_destroy = true
  
#   }
#   encryption {
#     default_kms_key_name = google_kms_crypto_key.terraform_state_bucket.id
#   }
}
