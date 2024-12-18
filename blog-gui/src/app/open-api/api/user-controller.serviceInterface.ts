/**
 * OpenAPI definition
 *
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
import { HttpHeaders }                                       from '@angular/common/http';

import { Observable }                                        from 'rxjs';

import { ListUserRequest } from '../model/models';
import { ResponseIdDTO } from '../model/models';
import { ResponsePageUserDTO } from '../model/models';
import { UserRegistrationRequest } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface UserControllerServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * 
     * 
     * @param request 
     */
    listUser(request: ListUserRequest, extraHttpRequestParams?: any): Observable<ResponsePageUserDTO>;

    /**
     * 
     * 
     * @param userRegistrationRequest 
     */
    userRegistration(userRegistrationRequest: UserRegistrationRequest, extraHttpRequestParams?: any): Observable<ResponseIdDTO>;

}
