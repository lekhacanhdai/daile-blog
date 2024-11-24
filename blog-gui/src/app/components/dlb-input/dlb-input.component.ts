import {Component, ElementRef, Input, ViewChild} from '@angular/core';

@Component({
  selector: 'app-dlb-input',
  templateUrl: './dlb-input.component.html',
  styleUrl: './dlb-input.component.scss'
})
export class DlbInputComponent {
  @Input() dataPlaceHolder = 'fdsaf';
  @Input() content = '';


  @ViewChild('placeHolder') placeHolder!: ElementRef<HTMLElement>;

  onFocus() {
    if (this.content !== '') {
      this.placeHolder.nativeElement.style.display = 'none';
    }
  }
}
