import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PostDTO } from '../../open-api/model/post-dto';
import { PostService } from '../../services/post.service';
@Component({
  selector: 'app-list-post',
  templateUrl: './list-post.component.html',
  styleUrl: './list-post.component.scss',
})
export class ListPostComponent implements OnInit {
  constructor(
    private _router: Router,
    private postService: PostService,
  ) {}
  posts: PostDTO[] = [];
  protected readonly navigator = navigator;

  onClick(id: string | undefined) {
    if (id) this._router.navigate([`posts/${id}`]).then(() => {});
  }

  ngOnInit(): void {
    this.postService.listPost({}).subscribe((res) => {
      if (res.data?.items) this.posts = res.data?.items;
    });
  }
}
