import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {

  isCollapsed: boolean = false;

  constructor(
    private auth: AuthService
  ) { }

  ngOnInit(): void {
  }

  loggedIn() {
    return this.auth.checkLogin();
  }

}
