# DevOps Vriddhi Terraform Workflow

This project contains the Terraform workflow for the Vriddhi GPC project.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

## Some pointers , useful while automating terraform

1. GCP api needs to be enabled using gcloud console or through web console
2. Resource admin role need to be provided to service account, use the below glcoud command line command after connecting to gcloud using the auth

Google cloud command line for resource administration

gcloud projects get-iam-policy vriddhi-419806 \
--flatten="bindings[].members" \
--format='table(bindings.role)' \
--filter="bindings.members:vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com"

gcloud projects add-iam-policy-binding vriddhi-419806 \
--member=serviceAccount:vriddhi-service-account@vriddhi-419806.iam.gserviceaccount.com \
--role=roles/resourcemanager.projectIamAdmin

gcloud iam roles describe roles/resourcemanager.projectIamAdmin


## Understand GCP IAM Policy , IAM Binding and IAMMember
1. https://xebia.com/blog/how-to-name-your-google-project-iam-resources-in-terraform/


2. https://stackoverflow.com/questions/63915353/what-is-the-meaning-of-authoritative-and-authoritative-for-gcp-iam-bindings

3. https://bh3r1th.medium.com/authoritative-vs-non-authoritative-terraform-resources-for-gcp-iam-policies-1173edad119c  

## Cloud KMS key admin 
gcloud kms keys add-iam-policy-binding name of the key --location global  --keyring golden-goose  --member serviceAccount:my-service-account@my-project.iam.gserviceaccount.com  --role roles/cloudkms.cryptoKeyEncrypterDecrypter

gcloud projects add-iam-policy-binding vriddhi-419806 \
--member=serviceAccount:service-288566726775@gs-project-accounts.iam.gserviceaccount.com \
--role=roles/cloudkms.admin
Then do this : https://stackoverflow.com/questions/56320241/permission-denied-on-cloud-kms-key-when-using-cloud-storage
curl -X GET -H "$(oauth2l header cloud-platform)" \
  "https://www.googleapis.com/storage/v1/projects/vriddhi-419806/serviceAccount"

  ##### For the Error -> Error loading zone 'us-east1-b': googleapi: Error 403: Required 'compute.zones.get' permission for forbidden

  Try the solution from : https://stackoverflow.com/questions/48232189/google-compute-engine-required-compute-zones-get-permission-error
  By Piotr Gaczkowski
  using gcloud command line 
  gcloud projects add-iam-policy-binding vriddhi-419806 \
--member=serviceAccount:service-288566726775@gs-project-accounts.iam.gserviceaccount.com \
--role=rroles/compute.instanceAdmin
gcloud projects add-iam-policy-binding vriddhi-419806 \
--member=serviceAccount:service-288566726775@gs-project-accounts.iam.gserviceaccount.com \
--role=roles/editor
gcloud projects add-iam-policy-binding vriddhi-419806 \
--member=serviceAccount:service-288566726775@gs-project-accounts.iam.gserviceaccount.com \
--role=roles/iam.serviceAccountUser

##### Use this to manage different environments : 
https://blog.gruntwork.io/how-to-manage-multiple-environments-with-terraform-using-branches-875d1a2ee647 ## TODO 

### GKE cluster setup using terraform 
https://www.youtube.com/watch?v=X_IK0GBbBTw&t=767s&ab_channel=AntonPutra  

#### ver important Link #######

