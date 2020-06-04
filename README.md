# ImmunizationSubmitterReferenceImplementation
Developed for AIRA by volunteers from Amazon, Inc. as part of the CTPS Gives initiative and Choice Hotels, Intl. as part of Room to Give. This is intended to be used by IIS and EHR developoers/staff to test their ability to receive HL7 messgaes related to COVID-19 seriological evidence of immunity and history of disease.

# Dependencies
JDK

Apache Maven

AWS CLI

NodeJS

AWS CDK

# One-time Set-up Commands
cdk bootstrap aws://unknown-account/unknown-region

# Build
mvn clean package

cdk synth

# Deploy back-end
cdk deploy ImmunizationSubmitterReferenceStack

# Deploy front-end stack (supports UI, a separate project deployed separately to S3)
cdk deploy ImmunizationSubmitterWebsiteStack