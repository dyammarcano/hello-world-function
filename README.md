[![Deploy to Azure Functions](https://github.com/dyammarcano/hello-world-function/actions/workflows/azure.yml/badge.svg)](https://github.com/dyammarcano/hello-world-function/actions/workflows/azure.yml)

# Example of using GitHub Actions to deploy a function app to Azure

This is a sample project that shows how to use GitHub Actions to deploy a function app to Azure.

## Prerequisites

- An Azure subscription. If you don't have an Azure subscription, create a [free account](https://azure.microsoft.com/free/?WT.mc_id=javascript-0000-jopapa).
- A GitHub account. If you don't have a GitHub account, create a [free account](https://github.com/join).
- [Docker](https://www.docker.com/products/docker-desktop) installed on your development machine.
- [Node.js](https://nodejs.org/en/download/) installed on your development machine.
- [Visual Studio Code](https://code.visualstudio.com/?WT.mc_id=javascript-0000-jopapa) installed on your development machine.
- [Azure Functions extension](https://marketplace.visualstudio.com/items?itemName=ms-azuretools.vscode-azurefunctions&WT.mc_id=javascript-0000-jopapa) for Visual Studio Code installed on your development machine.
- [Azure Functions Core Tools](https://docs.microsoft.com/en-us/azure/azure-functions/functions-run-local?WT.mc_id=javascript-0000-jopapa) installed on your development machine.
- [Azure CLI](https://docs.microsoft.com/en-us/cli/azure/install-azure-cli?WT.mc_id=javascript-0000-jopapa) installed on your development machine.
- [GitHub CLI](https://cli.github.com/) installed on your development machine.
- [act](https://nektosact.com/) installed on your development machine.

## Create an Azure resource group

An Azure resource group is a logical container into which Azure resources are deployed and managed.

1. Sign in to the [Azure portal](https://portal.azure.com/?WT.mc_id=javascript-0000-jopapa).
2. Select **Resource groups** from the left menu.
3. Select **Add**.
4. Enter a **Resource group name**.
5. Select a **Subscription**.
6. Select a **Region**.
7. Select **Review + create**.
8. Select **Create**.
9. Select **Go to resource group**.
10. Select **Overview**.

## Create an Azure Container Registry

An Azure Container Registry is a private Docker registry in Azure.

1. Select **+ Add**.
2. Search for **Container Registry**.
3. Select **Container Registry**.
4. Select **Create**.
5. Enter a **Registry name**.
6. Select a **Resource group**.
7. Select a **Location**.
8. Select **Create**.
9. Select **Go to resource**.
10. Select **Access keys**.
11. Select **Enable** next to **Admin user**.
12. Select **Copy** next to **Login server**, and save the value for later.
13. Select **Copy** next to **Username**, and save the value for later.
14. Select **Copy** next to **Password**, and save the value for later.
15. Select **OK**.

## Create an Azure Container Instance
