import { afterRender, Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PostService } from '../../services/post.service';
import { HighlightJS } from 'ngx-highlightjs';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-post-detail',
  templateUrl: './post-detail.component.html',
  styleUrl: './post-detail.component.scss',
})
export class PostDetailComponent implements OnInit {
  title = '';
  content = '';
  tags: string[] = ['Angular', 'Spring', 'React'];

  constructor(
    private route: ActivatedRoute,
    private postService: PostService,
    elementRef: ElementRef,
    private highlightService: HighlightJS,
    private titleService: Title,
  ) {
    afterRender(() => {
      this.titleService.setTitle(this.title);
      elementRef.nativeElement
        .querySelectorAll('pre code')
        .forEach((block: HTMLElement) => {
          this.highlightService.highlightElement(block).then(() => {});
        });
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('postId') || '';
    this.postService.getPostById(id).subscribe((post) => {
      if (post?.success) {
        this.title = post.data?.title || '';
        this.content = post.data?.content || '';
      }
    });
  }
}
