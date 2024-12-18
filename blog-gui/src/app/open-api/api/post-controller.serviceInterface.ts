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

import { CreatePostRequest } from '../model/models';
import { ListPostRequest } from '../model/models';
import { ResponseIdDTO } from '../model/models';
import { ResponsePagePostDTO } from '../model/models';
import { ResponsePostDTO } from '../model/models';


import { Configuration }                                     from '../configuration';



export interface PostControllerServiceInterface {
    defaultHeaders: HttpHeaders;
    configuration: Configuration;

    /**
     * 
     * 
     * @param createPostRequest 
     */
    createPost(createPostRequest: CreatePostRequest, extraHttpRequestParams?: any): Observable<ResponseIdDTO>;

    /**
     * 
     * 
     * @param id 
     */
    getPostById(id: string, extraHttpRequestParams?: any): Observable<ResponsePostDTO>;

    /**
     * 
     * 
     * @param request 
     */
    listPost(request: ListPostRequest, extraHttpRequestParams?: any): Observable<ResponsePagePostDTO>;

}
