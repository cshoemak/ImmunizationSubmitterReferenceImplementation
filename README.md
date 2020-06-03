# ImmunizationSubmitterReferenceImplementation
Developed for AIRA by volunteers from Amazon, Inc. as part of the CTPS Gives initiative and Choice Hotels, Intl. as part of Room to Give. This is intended to be used by IIS and EHR developoers/staff to test their ability to receive HL7 messgaes related to COVID-19 seriological evidence of immunity and history of disease.

# Dependencies
Apache Maven
AWS CLI
NodeJS
AWS CDK

# One-time Set-up Commands
cdk bootstrap aws://unknown-account/unknown-region

# Build and Deploy
mvn clean install
cdk synth
cdk deploy