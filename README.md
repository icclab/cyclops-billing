<a href="http://icclab.github.io/cyclops" target="_blank"><img align="middle" src="http://icclab.github.io/cyclops/assets/images/logo_big.png"></img></a>

## Billing microservice
Billing Micro Service as part of <a href="http://icclab.github.io/cyclops">Cyclops framework</a> is the final component before an invoice is generated. It interfaces with <a href="https://github.com/icclab/cyclops-rc">RC service</a> to get a list of Charge Data Records for a user, similarly a list of SLA violations are got from the external SLA module to be combined to generate an invoice. This is used to create bills. The billing service exposes different functionalities of invoice generation, tax & discount management through its REST APIs. 

### Download
     $ git clone https://github.com/icclab/cyclops-billing.git
### Installation
Make sure you've already installed <a href="https://github.com/icclab/cyclops-udr" target="_blank">UDR</a> and <a href="https://github.com/icclab/cyclops-rc" target="_blank">RC</a> microservices, as Billing requires the same prerequisites. If you want to run these microservices on different machines, then just install UDR's prerequisites, without deploying others again. Then continue with commands below:

     $ cd cyclops-billing/install
     $ chmod +x ./*
     $ bash setup_billing.sh

#### Configuration
 * At the end of the installation process you will be asked for your deployment credentials and to modify any configuration parameters, **please do not ignore this step.**
 * If there is a need to update your configuration, you can find it stored here cyclops-billing/src/main/webapp/WEB-INF/configuration.txt

### Deployment
     $ bash deploy_billing.sh

### Documentation
  Visit the <a href="https://github.com/icclab/cyclops-billing/wiki">Wiki</a> for detailed explanation and API reference guide.

### Cyclops architecture
<img align="middle" src="http://blog.zhaw.ch/icclab/files/2013/05/overall_architecture.png" alt="CYCLOPS Architecture" height="500" width="600"></img>

#### Billing microservice
<img align="middle" src="http://icclab.github.io/cyclops/assets/images/architecture/billing.png" alt="Billing Service Architecture" height="400" width="700"></img>

### Bugs and issues
  To report any bugs or issues, please use <a href="https://github.com/icclab/cyclops-billing/issues">Github Issues</a>
  
### Communication
  * Email: icclab-rcb-cyclops[at]dornbirn[dot]zhaw[dot]ch
  * Website: <a href="http://icclab.github.io/cyclops" target="_blank">icclab.github.io/cyclops</a>
  * Blog: <a href="http://blog.zhaw.ch/icclab" target="_blank">http://blog.zhaw.ch/icclab</a>
  * Tweet us @<a href="https://twitter.com/ICC_Lab">ICC_Lab</a>
   
### Developed @
<img src="http://blog.zhaw.ch/icclab/files/2014/04/icclab_logo.png" alt="ICC Lab" height="180" width="620"></img>

### License
 
      Licensed under the Apache License, Version 2.0 (the "License"); you may
      not use this file except in compliance with the License. You may obtain
      a copy of the License at
 
           http://www.apache.org/licenses/LICENSE-2.0
 
      Unless required by applicable law or agreed to in writing, software
      distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
      WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
      License for the specific language governing permissions and limitations
      under the License.