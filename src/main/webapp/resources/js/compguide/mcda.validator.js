/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var flag = 0;
            
            function validation_choose_crta_1(){
                $input1 = $('input[name$=choose_ca1]').val();
                var min = document.getElementById('mina').innerText;
                var max = document.getElementById('maxa').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input1 = parseInt($input1);
                if ($input1 >= min && $input1 <= max){
                    flag = 0;
                console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_ca1]').addClass('choose_border');
                    $('[id$=criteria_a1]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_ca1]').hasClass('choose_border')){
                        $('input[name$=choose_ca1]').removeClass("choose_border");
                        $('[id$=criteria_a1]').css('color', '');
                    }
                }
            }

            function validation_choose_crta_2(){
                $input2 = $('input[name$=choose_ca2]').val();
                var min = document.getElementById('mina').innerText;
                var max = document.getElementById('maxa').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input2 = parseInt($input2);
                if ($input2 >= min && $input2 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_ca2]').addClass('choose_border');
                    $('[id$=criteria_a2]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_ca2]').hasClass('choose_border')){
                        $('input[name$=choose_ca2]').removeClass("choose_border");
                        $('[id$=criteria_a2]').css('color', '');
                    }
                }
            }

            function validation_choose_crta_3(){
                $input3 = $('input[name$=choose_ca3]').val();
                var min = document.getElementById('mina').innerText;
                var max = document.getElementById('maxa').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input3 = parseInt($input3);
                if ($input3 >= min && $input3 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_ca3]').addClass('choose_border');
                    $('[id$=criteria_a3]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_ca3]').hasClass('choose_border')){
                        $('input[name$=choose_ca3]').removeClass("choose_border");
                        $('[id$=criteria_a3]').css('color', '');
                    }
                }
            }


            function validation_choose_crtb_1(){
                $input4 = $('input[name$=choose_cb1]').val();
                var min = document.getElementById('minb').innerText;
                var max = document.getElementById('maxb').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input4 = parseInt($input4);
                if ($input4 >= min && $input4 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cb1]').addClass('choose_border');
                    $('[id$=criteria_b1]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cb1]').hasClass('choose_border')){
                        $('input[name$=choose_cb1]').removeClass("choose_border");
                        $('[id$=criteria_b1]').css('color', '');
                    }
                }
            }

            function validation_choose_crtb_2(){
                $input5 = $('input[name$=choose_cb2]').val();
                var min = document.getElementById('minb').innerText;
                var max = document.getElementById('maxb').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input5 = parseInt($input5);
                if ($input5 >= min && $input5 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cb2]').addClass('choose_border');
                    $('[id$=criteria_b2]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cb2]').hasClass('choose_border')){
                        $('input[name$=choose_cb2]').removeClass("choose_border");
                        $('[id$=criteria_b2]').css('color', '');
                    }
                }
            }

            function validation_choose_crtb_3(){
                $input6 = $('input[name$=choose_cb3]').val();
                var min = document.getElementById('minb').innerText;
                var max = document.getElementById('maxb').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input6 = parseInt($input6);
                if ($input6 >= min && $input6 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cb3]').addClass('choose_border');
                    $('[id$=criteria_b3]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cb3]').hasClass('choose_border')){
                        $('input[name$=choose_cb3]').removeClass("choose_border");
                        $('[id$=criteria_b3]').css('color', '');
                    }
                }
            }

            function validation_choose_crtc_1(){
                $input7 = $('input[name$=choose_cc1]').val();
                var min = document.getElementById('minc').innerText;
                var max = document.getElementById('maxc').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input7 = parseInt($input7);
                if ($input7 >= min && $input7 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cc1]').addClass('choose_border');
                    $('[id$=criteria_c1]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cc1]').hasClass('choose_border')){
                        $('input[name$=choose_cc1]').removeClass("choose_border");
                        $('[id$=criteria_c1]').css('color', '');
                    }
                }
            }

            function validation_choose_crtc_2(){
                $input8 = $('input[name$=choose_cc2]').val();
                var min = document.getElementById('minc').innerText;
                var max = document.getElementById('maxc').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input8 = parseInt($input8);
                if ($input8 >= min && $input8 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cc2]').addClass('choose_border');
                    $('[id$=criteria_c2]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cc2]').hasClass('choose_border')){
                        $('input[name$=choose_cc2]').removeClass("choose_border");
                        $('[id$=criteria_c2]').css('color', '');
                    }
                }
            }

            function validation_choose_crtc_3(){
                $input9 = $('input[name$=choose_cc3]').val();
                var min = document.getElementById('minc').innerText;
                var max = document.getElementById('maxc').innerText;
                min = parseInt(min);
                max = parseInt(max);
                $input9 = parseInt($input9);
                if ($input9 >= min && $input9 <= max){
                    flag = 0;
                    console.log("Dentro do minimo");
                }
                else{
                    console.log("fora do raio");
                    flag = 1;
                    console.log(flag);
                }

                if (flag === 1){
                    $('input[name$=choose_cc3]').addClass('choose_border');
                    $('[id$=criteria_c3]').css('color', 'red');
                }
                else{
                    if ($('input[name$=choose_cc3]').hasClass('choose_border')){
                        $('input[name$=choose_cc3]').removeClass("choose_border");
                        $('[id$=criteria_c3]').css('color', '');
                    }
                }
            };

            function validate_from_range(){
                validation_choose_crta_1();
                validation_choose_crta_2();
                validation_choose_crta_3();
                validation_choose_crtb_1();
                validation_choose_crtb_2();
                validation_choose_crtb_3();
                validation_choose_crtc_1();
                validation_choose_crtc_2();
                validation_choose_crtc_3();
            };


            function mostra() {

                //range for a 
                var x = document.getElementById('mina').innerText;
                var y = document.getElementById('maxa').innerText;
                //range for b

                var z = document.getElementById('minb').innerText;
                var s = document.getElementById('maxb').innerText;
                //range for c

                var r = document.getElementById('minc').innerText;
                var t = document.getElementById('maxc').innerText;
                console.log(x);
                console.log(y);
                var a = $('[id$=amin]').val(x);
                var b = $('[id$=amax]').val(y);
                var c = $('[id$=bmin]').val(z);
                var d = $('[id$=bmax]').val(s);
                var e = $('[id$=cmin]').val(r);
                var f = $('[id$=cmax]').val(t);
                console.log(a.val());
                console.log(b.val());
                console.log(c.val());
                console.log(d.val());
                console.log(e.val());
                console.log(f.val());
            };
