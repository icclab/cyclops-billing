## Introduction
Billing Micro Service as part of Cyclops framework is the final component before an invoice is generated. It interfaces with RC service to get a list of Charge Data Records for a user, similarly a list of SLA violations are got from the external SLA module to be combined to generate an invoice. This is used to create bills. The billing service exposes different functionalities of invoice generation, tax & discount management through its REST APIs. 

## Getting Started
#### Process
* Clone the repo at https://github.com/icclab/cyclops-billing.git
* Update the configuration file at src/main/webapp/WEB-INF/configuration.txt
* Change directory to /install, edit the file permission and run install.sh

#### Installation Steps
     $ git clone https://github.com/icclab/cyclops-billing.git
     $ cd cyclops-billing/install
     $ chmod +x ./*
     $ bash install.sh
     
### Architecture
#### * CYCLOPS Rating Charging & Billing Framework
<img align="middle" src="http://icclab.github.io/cyclops/images/overall_architecture.png" alt="CYCLOPS Architecture" height="480" width="600"></img>

#### * Billing Micro Service
<img align="middle" src="http://icclab.github.io/cyclops/images/BillingService.png" alt="Billing Service Architecture" height="400" width="700"></img>

#### Documentation
1. <a href="https://github.com/icclab/cyclops-billing/wiki/API-Documentation">API Documentation</a>

#### Bugs & Issues
To report any bugs or issues, please use <a href="https://github.com/icclab/cyclops-billing/issues">Github Issues</a>

### Contact Us
  * Issues/Ideas/Suggestions : <a href="https://github.com/icclab/cyclops-billing/issues">GitHub Issue</a>
  * Email : <a href="http://blog.zhaw.ch/icclab/srikanta-patanjali/">Srikanta</a> (pata at zhaw[dot]ch) or <a href="http://blog.zhaw.ch/icclab/piyush_harsh/">Piyush</a> (harh at zhaw[dot]ch)
  * Website : http://blog.zhaw.ch/icclab/ 
  * Tweet us @<a href="https://twitter.com/ICC_Lab">ICC_Lab</a>
   
### Developed @
<a href="http://blog.zhaw.ch/icclab/"><img src="http://blog.zhaw.ch/icclab/files/2014/04/icclab_logo.png" alt="ICC Lab" height="180" width="620"></img></a>

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


