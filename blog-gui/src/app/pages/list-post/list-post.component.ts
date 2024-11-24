import {Component, OnInit} from '@angular/core';
import {Post} from './post.dto';
import {Router} from '@angular/router';
import {PostDTO} from '../../open-api/model/post-dto';
import {PostService} from '../../services/post.service';

const mockPost: Post[] = [
  {id: 1, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.  fasdkfjsad fh fasodhf sadf  fhsadjf sf  fasdjf hdsa fh fsa dfhsdf hsdf  fashdfj dsf  fkhsadjf sdf  f askdf sdf  fdsahf sdf   dsafsdfs af  fashdfj '},
  {id: 2, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 3, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 4, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 5, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 6, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 7, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
  {id: 8, title: 'How to install Java', subtitle: 'Dai Le', imageUrl: 'https://cdn.bap-software.net/2024/01/03211643/How-is-AI-applied-to-Java-programming-e1704266486769.jpg', time: '20-10-2022', content: 'Manual installation downloads an IFTW (Install From The Web) executable program file and requires minimum user intervention. When you run this program, it fetches all the required files from the web, so you must remain connected to the Internet during the installation.'},
]
@Component({
  selector: 'app-list-post',
  templateUrl: './list-post.component.html',
  styleUrl: './list-post.component.scss'
})
export class ListPostComponent implements OnInit{
  constructor(private _router: Router, private postService: PostService) { }
  posts: PostDTO[] = [];
  protected readonly navigator = navigator;

  onClick(id: string | undefined) {
    if (id)
    this._router.navigate([`posts/${id}`]).then(() => {})
  }

  ngOnInit(): void {
    this.postService.listPost({}).subscribe(res => {
      if (res.data?.items)
      this.posts = res.data?.items;
    })
  }


}
