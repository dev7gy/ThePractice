using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.Encodings.Web;
using System.Threading.Tasks;

namespace WebApplication1.Controllers
{
    public class HelloWorldController : Controller
    {
        /*
        public IActionResult Index()
        {
            return View();
        }
        */

        /* 
        // GET: /HelloWorld/ 
        public string Index()
        {
            return "This is my <b>default</b> action...";
        }
        */
        public IActionResult Index()
        {
            return View();
        }

        // 
        // GET: /HelloWorld/Welcome/ 

        public string Welcome(string name, int numTimes = 1)
        {
            return HtmlEncoder.Default.Encode($"Hello {name}, Numtimes is NumTimes is: {numTimes}");
        }

        public string Welcome2(string name, int ID = 1)
        {
            return HtmlEncoder.Default.Encode($"Hello {name}, ID: {ID}");
        }
    }
}
