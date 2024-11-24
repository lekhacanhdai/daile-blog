import {
  AfterViewInit,
  Directive,
  ElementRef
} from '@angular/core';
import {HighlightJS} from 'ngx-highlightjs';

@Directive({
  selector: '[appHighlightCode]'
})
export class HighlightCodeDirective implements AfterViewInit {

  constructor(private el: ElementRef, private highlightService: HighlightJS) {}

  ngAfterViewInit() {
    // Find all <pre><code> elements and highlight them
    this.el.nativeElement.querySelectorAll('pre code').forEach((block: HTMLElement) => {
      this.highlightService.highlightElement(block).then(() => {});
    });
  }

}
