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