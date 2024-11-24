import { Injectable } from '@angular/core';
import {
  CreatePostRequest,
  ListPostRequest,
  PostControllerService,
  ResponseIdDTO,
  ResponsePagePostDTO, ResponsePostDTO
} from '../open-api';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private service: PostControllerService) { }

  createPost(createPostRequest: CreatePostRequest): Observable<ResponseIdDTO> {
    return this.service.createPost(createPostRequest);
  }

  listPost(listPostRequest: ListPostRequest): Observable<ResponsePagePostDTO> {
    return this.service.listPost(listPostRequest);
  }

  getPostById(id: string): Observable<ResponsePostDTO> {
    return this.service.getPostById(id);
  }

}
