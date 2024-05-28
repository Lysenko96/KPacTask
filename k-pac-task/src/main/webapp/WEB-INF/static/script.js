// const dataset = new dhx.DataCollection();
// dataset.parse(companiesData);
//
// const layout = new dhx.Layout("layout", {
//     type: "space",
//     rows: [
//         {
//             id: "grid",
//             height: "35%"
//         },
//         {
//             id: "chart",
//         },
//     ]
// });
//
// const grid = new dhx.Grid(null, {
//     columns: [
//         { id: "month", header: [{ text: "Month" }], editable: false, type: "number" },
//         { id: "company A", header: [{ text: "Company A" }], type: "number" },
//         { id: "company B", header: [{ text: "Company B " }], type: "number" },
//         { id: "company C", header: [{ text: "Company C" }], type: "number" }
//     ],
//     editable: true,
//     autoWidth: true,
//     data: dataset
// });
//
// const config = {
//     type: "bar",
//     css: "dhx_widget--bg_white dhx_widget--bordered",
//     scales: {
//         "bottom": {
//             text: "month"
//         },
//         "left": {
//             maxTicks: 10,
//             max: 100,
//             min: 0
//         }
//     },
//     data: dataset
// };
//
// layout.getCell("grid").attach(grid);