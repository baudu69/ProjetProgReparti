import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  str: string = ""

  constructor(private router: Router) {
  }

  ngOnInit(): void {
  }

  search() {
    this.router.navigate(['/apprenant/search', this.str])
  }
}
