import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { RouterOutlet } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HeaderComponent } from './components/header/header.component';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { MatCardModule } from '@angular/material/card';
import { DlbCardComponent } from './components/dlb-card/dlb-card.component';
import { ListPostComponent } from './pages/list-post/list-post.component';
import { PostDetailComponent } from './pages/post-detail/post-detail.component';
import { DlbInputComponent } from './components/dlb-input/dlb-input.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
import { AppEditorComponent } from './components/editor/editor.component';
import { HighlightModule, provideHighlightOptions } from 'ngx-highlightjs';
import { HighlightPlusModule } from 'ngx-highlightjs/plus';
import { HighlightCodeDirective } from './directives/highlight-code.directive';
import { MatButtonModule } from '@angular/material/button';
import { ApiModule } from './open-api';
import {
  provideHttpClient,
  withInterceptorsFromDi,
} from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    DlbCardComponent,
    DlbCardComponent,
    ListPostComponent,
    PostDetailComponent,
    DlbInputComponent,
    AppEditorComponent,
    HighlightCodeDirective,
  ],
  imports: [
    RouterOutlet,
    BrowserModule,
    ReactiveFormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    MatCardModule,
    CKEditorModule,
    FormsModule,
    HighlightModule,
    HighlightPlusModule,
    MatButtonModule,
    ApiModule,
  ],
  providers: [
    provideAnimationsAsync(),
    provideHighlightOptions({
      fullLibraryLoader: () => import('highlight.js'),
    }),
    provideHttpClient(withInterceptorsFromDi()),
  ],
  exports: [DlbInputComponent],
  bootstrap: [AppComponent],
})
export class AppModule {}
