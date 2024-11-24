import {RouterModule, Routes} from '@angular/router';
import {AppEditor} from './components/editor/editor.component';
import {NgModule} from '@angular/core';
import {ListPostComponent} from './pages/list-post/list-post.component';
import {PostDetailComponent} from './pages/post-detail/post-detail.component';

const routes: Routes = [
  {path: "new-post", component: AppEditor},
  {path: "posts", component: ListPostComponent},
  {path: "posts/:postId", component: PostDetailComponent},
  { path: '', redirectTo: 'posts', pathMatch: 'full' },
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
