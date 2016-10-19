import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Test } from "../models/test";


@Component({
    selector: 'testList',
    templateUrl: 'app/tests/tests.component.html',
})
export class TestComponent implements OnInit {


    constructor (private router: Router){ }


    ngOnInit(){

    }

    goBack(){
        window.history.back();
    }
}