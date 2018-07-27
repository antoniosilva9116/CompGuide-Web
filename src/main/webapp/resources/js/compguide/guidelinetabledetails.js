/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var webServicePath = "http://localhost:8081/CompGuide/webresources/";
/* Formatting function for row details - modify as you need */
function format(data) {
    var desc = +(data.description === null) ? "There is no information" : data.description;
    // `d` is the original data object for the row
    var year = data.time.substring(0, 4);
    var month = data.time.substring(4, 6);
    var day = data.time.substring(6, 8);
    var hours = data.time.substring(8, 10);
    var minutes = data.time.substring(10, 12);
    var seconds = data.time.substring(12, 14);

    var date = new Date(year, month, day, hours, minutes, seconds, 000);

    return '<table cellpadding="1" border="0" width="50%" style="width: 50%;border-collapse: collapse;" role="grid">' +
            '<tr class="spaceUnder">' +
            '<td>  Patient Name ' +
            '</td>' +
            '<td>' +
            '<div class="row">' +
            '<div class="col-md-9"><div class="form-group">' +
            '<i class="fa fa-info">' +
            '<input name="form:tableform:authorship" type="text"' +
            'class="form-control" disabled="disabled" value="' + data.idpatient.name + '"/>' +
            '</i></div></div></div>' +
            '</td>' +
            '</tr>' +
            '<tr class="spaceUnder">' +
            '<td>   Patient Last Name </td> ' +
            '<td>' +
            '<div class="row">' +
            '<div class="col-md-9"><div class="form-group">' +
            '<i class="fa fa-info">' +
            '</span>' +
            '<input name="form:tableform:authorship" type="text"' +
            'class="form-control" disabled="disabled" value="' + data.idpatient.lastname + '">' +
            '</i></div></div> </div>' +
            '</td>' +
            '</tr>' +
            '<tr class="spaceUnder">' +
            '<td>  Last Execution </td>' +
            '<td> <div class="row">' +
            '<div class="col-md-9"><div class="form-group">' +
            '<i class="glyphicon glyphicon-calendar">' +
            '<input name="form:tableform:authorship" type="text"' +
            'class="form-control" disabled="disabled" value="' + date.toDateString() + '">' +
            '</i></div></div></div>' +
            '</div> </td>' +
            '</tr>' +
            '<tr class="spaceUnder">' +
            '<td> <div class="row">' +
            '<div class="col-md-9"><div class="form-group">' +
            '</div></div></div>' +
            '</div> </td>' +
            '</tr>' +
            '</table>';
}

function updateTable() {
    var table = $('#guidelines').DataTable({
        "ordering": false
    });
    // Add event listener for opening and closing details
    $('#guidelines tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);
        if (row.child.isShown()) {
// This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            $.ajax({
                url: webServicePath + 'com.compguide.web.persistence.entities.guideexec/' + tr.attr('id'),
                type: 'GET',
                dataType: 'JSON',
                contentType: 'text/plain; charset=utf-8',
                cache: false,
                success: function (data) {
                    // Open this row
                    row.child(format(data)).show();
                    tr.addClass('shown');
                },
                error: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        }
    });
}

function initTableAction() {
    var tableaction = $('#actions').DataTable({
        "ordering": false,
        "info": false,
        "paging": false
    });
    $('.check').on('click', function () {

    });
    // Add event listener for opening and closing details
    $('#actions tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = tableaction.row(tr);
        if (row.child.isShown()) {
            // This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            var id = tr.attr('id');
            var dataaction = $('#actioncontent' + id).clone();
            dataaction.css('display', '');
            row.child(dataaction).show();
            tr.addClass('shown');
        }
    });
}

$(document).ready(function () {
    var table = $('#guidelines').DataTable({
        "ordering": false
    });
    // Add event listener for opening and closing details
    $('#guidelines tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row(tr);
        if (row.child.isShown()) {
// This row is already open - close it
            row.child.hide();
            tr.removeClass('shown');
        } else {
            $.ajax({
                url: webServicePath + 'com.compguide.web.persistence.entities.guideexec/' + tr.attr('id'),
                type: 'GET',
                dataType: 'JSON',
                contentType: 'text/plain; charset=utf-8',
                cache: false,
                success: function (data) {
                    // Open this row
                    row.child(format(data)).show();
                    tr.addClass('shown');
                },
                error: function (err) {
                    alert(JSON.stringify(err));
                }
            });
        }
    });
});
