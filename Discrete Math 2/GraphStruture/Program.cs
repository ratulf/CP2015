using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;

namespace GraphStruture
{
    class EINEW 
    {
        static void Main(string[] args)
        {
            var n = NextInt();
            var m = NextInt();
            var q = NextInt();

            var vertices = ReadGraph(n, m);

            var builder = new StringBuilder();
            for(var i = 0; i < q; i++)
            {
                var c = NextInt() -1;
                foreach(var children in vertices[c].children)
                {
                    builder.Append((children.id + 1) + " ");
                }
                builder.Remove(builder.Length - 1, 1);
                builder.Append("\n");
            }

            Console.Write(builder);
            Console.ReadLine();
        }

        static Vertex[] ReadGraph(int nVertices, int nEdges)
        {
            Vertex[] vertices = new Vertex[nVertices];
            for (var i = 0; i < nVertices; i++)
            {
                vertices[i] = new Vertex(i);
            }

            for (var i = 0; i < nEdges; i++)
            {
                var vi = NextInt() - 1;
                var vj = NextInt() - 1;
                vertices[vj].AddChild(vertices[vi]);
            }
            return vertices;
        }

        class Vertex
        {
            public int id = -1;
            public bool visited = false;
            public List<Vertex> children = new List<Vertex>();

            public Vertex(int id)
            {
                this.id = id;
            }

            public void AddChild(Vertex child)
            {
                children.Add(child);
            }
        }

        static int s_index = 0;
        static List<string> s_tokens;

        private static string Next()
        {
            while (s_tokens == null || s_index == s_tokens.Count)
            {
                s_tokens = Console.ReadLine().Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                s_index = 0;
            }
            return s_tokens[s_index++];
        }

        private static bool HasNext()
        {
            while (s_tokens == null || s_index == s_tokens.Count)
            {
                s_tokens = null;
                s_index = 0;
                var nextLine = Console.ReadLine();
                if (nextLine != null)
                {
                    s_tokens = nextLine.Split(new char[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).ToList();
                }
                else
                {
                    return false;
                }

            }
            return s_tokens.Count > 0;
        }

        private static int NextInt()
        {
            return Int32.Parse(Next());
        }

        private static long NextLong()
        {
            return Int64.Parse(Next());
        }

        /*
        static int s_index = 0;
        static string[] s_tokens;

        static EIHCON2()
        {
            s_tokens = (new StreamReader(Console.OpenStandardInput())).ReadToEnd().Split(new char[] { ' ', '\n', '\r' }, StringSplitOptions.RemoveEmptyEntries);
        }

        private static string Next()
        {
            return s_tokens[s_index++];
        }

        private static bool HasNext()
        {
            return s_index < s_tokens.Length;
        }

        private static int NextInt()
        {
            return Int32.Parse(Next());
        }

        private static long NextLong()
        {
            return Int64.Parse(Next());
        }
         */
    }
}
