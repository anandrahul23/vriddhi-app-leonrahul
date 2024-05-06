variable "project_id" {
  description = "The project ID to host the cluster in"
}
variable "cluster_name" {
  description = "The name for the GKE cluster"
  default     = "vriddhik8s-cluster-stage"
}
variable "env_name" {
  description = "The environment for the GKE cluster"
  default     = "staging"
}
variable "region" {
  description = "The region to host the cluster in"
  default     = "us-east1"
}
variable "network" {
  description = "The VPC network created to host the cluster in"
  default     = "gke-network-staging"
}
variable "subnetwork" {
  description = "The subnetwork created to host the cluster in"
  default     = "gke-subnet-staging"
}
variable "ip_range_pods_name" {
  description = "The secondary ip range to use for pods"
  default     = "ip-range-pods"
}
variable "ip_range_services_name" {
  description = "The secondary ip range to use for services"
  default     = "ip-range-services"
}

 variable "router_name" {
        type    = string
        default = "router-staging"
    }

variable "nat_gateway_name" {
        type    = string
        default = "nat-gateway-staging"
    }
    variable "node_count" {
    description = "Number of initial nodes in the cluster"
    type        = number
    default     = 1
}
variable "machine_type" {
    description = "Machine type for the nodes in the cluster"
    type        = string
    default     = "n1-standard-1"
}
variable "enable_http_load_balancing" {
    description = "Enable HTTP load balancing"
    type        = string
    default     = "true"
}
variable "enable_horizontal_pod_autoscaling" {
    description = "Enable horizontal pod autoscaling"
    type        = string
    default     = "false"
  
}
variable "disk_size_gb" {
    description = "Disk size for the nodes in the cluster"
    type        = number
    default     = 30
  
}
variable "disk_type" {
    description = "Disk type for the nodes in the cluster"
    type        = string
    default     = "pd-ssd"
  
}

variable "zone" {
    description = "The zone to host the cluster in"
    default     = "us-east1-b"
}