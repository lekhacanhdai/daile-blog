import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dlb-card',
  templateUrl: './dlb-card.component.html',
  styleUrl: './dlb-card.component.scss',
})
export class DlbCardComponent {
  @Input({ required: true }) subTitle = '';
  @Input({ required: true }) title = '';
  @Input({ required: true }) content = '';
  @Input() imageUrl = '';
  @Input() time = '';
}
