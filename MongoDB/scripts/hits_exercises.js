function map() {
       var key = {
           resource: this.resource,
           year: this.date.getFullYear(),
           month: this.date.getMonth(),
           day: this.date.getDate()
       };
       emit(key, {count: 1});
   }

   function reduce(key, value) {
    var sum = 0;
    values.forEach(function(value) {
        sum += value['count'];
    });
    return {count: sum};
   }