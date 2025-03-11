

# resource "kubernetes_namespace" "tekton_pipelines" {
#   metadata {
#     name = "tekton-pipelines"
#   }
# }

# data "http" "tekton_release" {
#   url = "https://storage.googleapis.com/tekton-releases/pipeline/latest/release.yaml"
# }

# resource "kubernetes_manifest" "tekton_pipelines" {
#   manifest = {
#     apiVersion = "v1"
#     kind       = "List"
#     items      = yamldecode(data.http.tekton_release.body).items
#   }
# }