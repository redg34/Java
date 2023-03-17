import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-tile',
  templateUrl: './tile.component.html',
  styleUrls: ['./tile.component.scss']
})
export class TileComponent implements OnInit {
  @Input() tileInfo: any;



  constructor(
    private _router: Router
  ) { }

  ngOnInit(): void {
  }

  onNavigate(): void {
    this._router.navigate(this.tileInfo.action)
    .then((result: boolean) => {
      console.log(`Something happens ${result ? 'ok': 'ko'}`)
    })
  }
}
