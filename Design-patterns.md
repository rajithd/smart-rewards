#Components
## API
    location : smart-rewards/modules/api
    purpose : Provide web services, handle business logic and act as a only interface to mongo database
    Design patterns:
    1. MVC : Controller layer - com.cmr.api.controllers
           : Business logic or service layer - com.cmr.api.service
           : Models - Separate project smart-rewards/core-beans (com.cmr.beans)
    2. Factory : com.cmr.beans.event.EventFactory
    3. Intercepting filter pattern : com.cmr.api.security.APIAuthenticationFilter
    4. DAO pattern : inside com.cmr.api.dao package
    5. Front Controller - Provided by spring mvc framework (DispatcherServlet)

## Campaign management
    location : smart-rewards/modules/campaign-management
    purpose  : Separate presentation layer
    Design patterns:
    1. MVC : Controller layer - com.cmr.cm.controllers
           : Service layer - com.cmr.cm.service
    2. Front Controller - Provided by spring mvc framework (DispatcherServlet)


## Decoder
    location : smart-rewards/modules/decoder
    purpose : Decode CDR files and send to api
    Design patterns :
    1. Strategy : com.cmr.decoder.service.UploadServiceStrategy

## Ultra ESB
    Popular ESB providing 65 enterprise integration patterns
    Based on 6 root patterns this project implement
    1. Messaging
    2. Pipes and Filters
    3. Message End points

## Security
    Transport level security - HTTPS
    Basic Authentication with ESB and api

